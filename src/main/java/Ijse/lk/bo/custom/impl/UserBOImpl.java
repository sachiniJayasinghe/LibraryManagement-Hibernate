package Ijse.lk.bo.custom.impl;

import Ijse.lk.bo.custom.UserBO;
import Ijse.lk.repository.RepositoryFactory;
import Ijse.lk.repository.custom.UserRepository;
import Ijse.lk.dto.userDto;
import Ijse.lk.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
    UserRepository userDAO = (UserRepository) RepositoryFactory.getDaoFactory().getDAO(RepositoryFactory.DAOTypes.USER);

    @Override
    public List<userDto> getAllUser() throws Exception {
        List<userDto> allUser= new ArrayList<>();
        List<User> all = userDAO.getAll();
        for (User u : all) {
            allUser.add(new userDto(u.getId(),u.getName(),u.getEmail(),u.getPassword()));
        }
        return allUser;
    }

    @Override
    public boolean addUser(userDto dto) throws Exception {
        return userDAO.add(new User(dto.getId(), dto.getName(), dto.getEmail(), dto.getPassword()));
    }

    @Override
    public boolean updateUser(userDto dto) throws Exception {
        return userDAO.update(new User(dto.getId(),dto.getName(),dto.getEmail(), dto.getPassword()));
    }

    @Override
    public boolean deleteUser(long user_id) throws Exception {
        return userDAO.delete(user_id);
    }
}
