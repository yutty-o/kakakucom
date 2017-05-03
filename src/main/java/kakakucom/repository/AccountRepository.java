package kakakucom.repository;

import kakakucom.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Nonnull;

/**
 * 会員登録レポジトリ
 */
@Mapper
public interface AccountRepository {

    int create(
        @Param("user") @Nonnull final User user
    );
}
