package com.tamnt.personal_finance_tracker.config;

import com.tamnt.personal_finance_tracker.model.Category;
import com.tamnt.personal_finance_tracker.model.User;
import com.tamnt.personal_finance_tracker.repository.CategoryRepository;
import com.tamnt.personal_finance_tracker.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepository, CategoryRepository categoryRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
        loadCategoryData();
    }

    private void loadUserData() {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setUserName("admin");
            user.setEmail("admin@gmail.com");
            user.setPassword(passwordEncoder.encode("123456"));

            userRepository.save(user);
            System.out.println("Created User default : admin / 123456");
        }
    }

    private void loadCategoryData() {
        if (categoryRepository.count() == 0) {
            List<Category> categories = Arrays.asList(
                new Category("Salary",1),
                new Category("Bonus",1),
                new Category("Tiền nhà",0),
                new Category("Ăn uống",0),
                new Category("Moving",0),
                new Category("Entertainment",0)
            );

            categoryRepository.saveAll(categories);
            System.out.println("--> Đã tạo " + categories.size() + " danh mục mẫu.");
        }
    }
}
