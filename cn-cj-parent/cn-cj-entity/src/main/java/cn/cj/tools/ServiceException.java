package cn.cj.tools;

/**
 * 业务层通用检查
 * @author chenjie
 *
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 2579592507322541131L;
	
	public ServiceException(String msg){
		super(msg);
	}
	
	public ServiceException(String msg, Throwable tb){
		super(msg,tb);
	}

}
