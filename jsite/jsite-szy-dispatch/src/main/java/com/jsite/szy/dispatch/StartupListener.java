package com.jsite.szy.dispatch;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.jsite.szy.dispatch.cache.CacheResourceUtils;


public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent evt) {
		if (evt.getApplicationContext().getParent() != null) {
			new Thread(new Runnable() {
				public void run() {
					CacheResourceUtils.cacheData();
				}
			}).start();
		}
	}
}
