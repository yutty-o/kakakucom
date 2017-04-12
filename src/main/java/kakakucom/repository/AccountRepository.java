package kakakucom.domain.repository;

import kakakucom.domain.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会員登録レポジトリ
 * Created by yutty on 2017/04/10
 */
@Mapper
public interface AccountRepository {

    List<User> findOne(@Param("email") final String email);

    User register(@Param("user") final User user);
}
