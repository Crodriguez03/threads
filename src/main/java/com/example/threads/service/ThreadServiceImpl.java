package com.example.threads.service;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.threads.dto.UserDTO;

import jakarta.annotation.PreDestroy;

@Service
public class ThreadServiceImpl implements ThreadService {	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@Override
	public void dynamicPool(Collection<UserDTO> users) {
		
		Integer nThreads = users.size() <= 10 ? users.size() : 10;
		ExecutorService executor = Executors.newFixedThreadPool(nThreads);
		for (UserDTO user : users) {
			executor.submit(() -> action(user));
		}

		try {
			executor.shutdown();
		    executor.awaitTermination(15, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
			log.warn("Se ha interrumpido el servicio");
			Thread.currentThread().interrupt();
		} finally {
		    if (!executor.isTerminated()) {
		    	log.warn("Se ha interrumpido el servicio. No ha terminado");
		    }
		    executor.shutdownNow();
		}
	}
	
	private static final ExecutorService generalExecutor = Executors.newFixedThreadPool(30);
	
	@Override
	public void sharePool(Collection<UserDTO> users) {
		for (UserDTO user : users) {
			generalExecutor.submit(() -> action(user));
		}
	}
	
	@Override
	public void parallelStream(Collection<UserDTO> users) {
		users.parallelStream().forEach(this::action);
	}
	
	@PreDestroy
    public void onDestroy() {
		generalExecutor.shutdown();
    }
	
	private void action(UserDTO user) {
		log.info("Ejecuntado acción para el usuario {} desde el hilo {}", user.getName(), Thread.currentThread().getName());
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
