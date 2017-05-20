package kakakucom.repository;

import kakakucom.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Nonnull;
import java.util.Optional;

@Mapper
public interface AccountRepository {

    int create(
        @Param("user") @Nonnull final User user
    );

    User findOne(
        @Param("email") @Nonnull final String email
    );
}
