package eeit45.group3.bakeyourlife.article.service;

import eeit45.group3.bakeyourlife.article.dao.TokenRepository;
import eeit45.group3.bakeyourlife.article.model.AuthenticationToken;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {

    @Autowired
    TokenRepository tokenRepository;



    public AuthenticationToken getToken(User user){
        return tokenRepository.findByUser(user);

    }

    public  User getUser(String token){
     final  AuthenticationToken authenticationToken = tokenRepository.findByToken(token);
     if(Objects.isNull(authenticationToken)){
         return null;
     }
      return authenticationToken.getUser();
    }

//    public void  authenticate(String token){
//        if(Objects.isNull(token)){
//            throw new  Exception("");
//        }
//    }
}
