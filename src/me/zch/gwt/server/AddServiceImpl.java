package me.zch.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import me.zch.gwt.client.AddService;

public class AddServiceImpl extends RemoteServiceServlet implements AddService{

	private static final long serialVersionUID = 1L;

	@Override
	public Integer add(int a, int b) {
		return a + b;
	}

}
