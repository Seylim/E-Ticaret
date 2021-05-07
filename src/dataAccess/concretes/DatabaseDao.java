package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseDao implements UserDao {

    List<User> userDataBase=new ArrayList<>();

    @Override
    public void Add(User user) {
        userDataBase.add(user);
        System.out.println(user.getFirstName() + " Adlı kullanıcı veritabanına eklendi.");
    }

    @Override
    public void Update(User user) {
        User updateUser = get(user.getId());
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setPassword(user.getPassword());
        System.out.println("Kullanıcı bilgileri güncellendi.");
    }

    @Override
    public void Delete(User user) {
        userDataBase.removeIf(obj->obj.getId() == user.getId());
        System.out.println("Kullanıcı bilgileri silindi.");
    }

    @Override
    public User GetByEmail(String email) {
        for (User user:userDataBase){
            if (user.geteMail() == email) return user;
        }
        return null;
    }

    @Override
    public User GetByEmailAndPassword(String email, String password) {
        for (User user:userDataBase){
            if (user.geteMail() == email && user.getPassword() == password){
                return user;
            }
        }
        return null;
    }

    @Override
    public User get(int id) {
        for (User user:userDataBase) {
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return userDataBase;
    }
}
