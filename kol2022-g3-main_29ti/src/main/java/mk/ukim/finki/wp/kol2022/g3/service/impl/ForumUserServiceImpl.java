package mk.ukim.finki.wp.kol2022.g3.service.impl;

import mk.ukim.finki.wp.kol2022.g3.model.ForumUser;
import mk.ukim.finki.wp.kol2022.g3.model.ForumUserType;
import mk.ukim.finki.wp.kol2022.g3.model.Interest;
import mk.ukim.finki.wp.kol2022.g3.model.exceptions.InvalidForumUserIdException;
import mk.ukim.finki.wp.kol2022.g3.repository.ForumUserRepository;
import mk.ukim.finki.wp.kol2022.g3.repository.InterestRepository;
import mk.ukim.finki.wp.kol2022.g3.service.ForumUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ForumUserServiceImpl  implements ForumUserService {

    private final ForumUserRepository forumUserRepository;
    private final InterestRepository interestRepository;

    public ForumUserServiceImpl(ForumUserRepository forumUserRepository, InterestRepository interestRepository) {
        this.forumUserRepository = forumUserRepository;
        this.interestRepository = interestRepository;
    }


    @Override
    public List<ForumUser> listAll() {
        return forumUserRepository.findAll();
    }

    @Override
    public ForumUser findById(Long id) {
        return forumUserRepository.findById(id).orElseThrow(InvalidForumUserIdException::new);
    }

    @Override
    public ForumUser create(String name, String email, String password, ForumUserType type, List<Long> interestId, LocalDate birthday) {
        List<Interest> interests = interestRepository.findAllById(interestId);
        ForumUser forumUser = new ForumUser(name, email, password, type, interests, birthday);
        forumUserRepository.save(forumUser);
        return forumUser;
    }

    @Override
    public ForumUser update(Long id, String name, String email, String password, ForumUserType type, List<Long> interestId, LocalDate birthday) {
        List<Interest> interests = interestRepository.findAllById(interestId);
        ForumUser forumUser = forumUserRepository.findById(id).orElseThrow(InvalidForumUserIdException::new);
        forumUser.setId(id);
        forumUser.setName(name);
        forumUser.setEmail(email);
        forumUser.setPassword(password);
        forumUser.setType(type);
        forumUser.setInterests(interests);
        forumUser.setBirthday(birthday);

        forumUserRepository.save(forumUser);

        return forumUser;
    }

    @Override
    public ForumUser delete(Long id) {
        ForumUser forumUser = forumUserRepository.getById(id);
        forumUserRepository.delete(forumUser);
        return forumUser;
    }

    @Override
    public List<ForumUser> filter(Long interestId, Integer age) {
        return null;
    }
}
