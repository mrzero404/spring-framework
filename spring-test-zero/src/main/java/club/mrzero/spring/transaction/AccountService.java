package club.mrzero.spring.transaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账户接口
 * @author: ChenHao
 * @create: 2019-10-08 18:38
 */
@Transactional(propagation = Propagation.REQUIRED)
public interface AccountService {
    void save() throws RuntimeException;
}