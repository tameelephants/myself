package cn.cj.service.shiro;
 
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
 
import java.util.concurrent.atomic.AtomicInteger;
 
/**
 * 密码加盐，账户锁定类
 * @author chenjie
 *
 */
public class RetryLimitHashedCredentialsMatcher extends
		HashedCredentialsMatcher {
 
	private Cache<String, AtomicInteger> passwordRetryCache;
 
	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}
 
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		String username = (String) token.getPrincipal();
		// 当前用户每登录一次,当前retryCount就++一次
		AtomicInteger retryCount = passwordRetryCache.get(username);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		if (retryCount.incrementAndGet() > 6) {
			// 如果当前登录的用户名和密码的次数大于6次, 则会锁定当前账号禁止登录(具体等限制登录时间会在当前xml中进行配置)
			throw new ExcessiveAttemptsException();
		}
 
		boolean matches = super.doCredentialsMatch(token, info);
		if (matches) {
			// 如果登录成功,清除当前账号的锁定登录次数
			passwordRetryCache.remove(username);
		}
		return matches;
	}
}
