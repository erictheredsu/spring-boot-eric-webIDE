package com.sap.b1.redistest.lettuce;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;

// reference https://redislabs.com/lp/redis-java/
public class LettuceClient implements AutoCloseable  {
	
	RedisClient client;
	RedisConnection<String, String> conn;
	public LettuceClient()
	{
		client = new RedisClient("10.58.136.142");
		conn = client.connect();	
		if(conn.ping().equalsIgnoreCase("Pong"))
		{
			System.out.println("Lettuce connect ok");
		}
		else
		{
			System.out.println("Lettuce connect fail");
		}
	}
	
	@Override
	public void close() throws Exception {
		conn.close();
		client.shutdown();
		System.out.println("Lettuce connect close");
	}
	
	public RedisConnection<String, String> getConn() {
		return conn;
	}
	public void setConn(RedisConnection<String, String> conn) {
		this.conn = conn;
	}
	
	
}
