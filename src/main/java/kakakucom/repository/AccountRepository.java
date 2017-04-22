package kakakucom.repository;

import kakakucom.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 会員登録レポジトリ
 * Created by ogawayuuki on 2017/04/10
 */
@Mapper
public interface AccountRepository {

    int create(
        @Param("user") final User user
    );
}
