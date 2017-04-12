package kakakucom.repository;

import kakakucom.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 会員登録レポジトリ
 * Created by yutty on 2017/04/10
 */
@Mapper
public interface AccountRepository {

//    List<User> findOne(@Param("email") final String email);

    int create(
        @Param("user") final User user
    );
}
