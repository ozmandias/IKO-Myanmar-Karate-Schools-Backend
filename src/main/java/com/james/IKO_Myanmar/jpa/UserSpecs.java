package com.james.IKO_Myanmar.jpa;

import com.james.IKO_Myanmar.models.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecs {
    public static Specification<User> hasEmail(String email) {
        Specification<User> hasEmailSpec = (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("email"), email);
        };
        return hasEmailSpec;
    }
}