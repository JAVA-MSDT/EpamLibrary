package com.epam.library.controller.builder;

import com.epam.library.entity.User;
import com.epam.library.entity.enumeration.Role;
import com.epam.library.util.constant.UserConstant;

import javax.servlet.http.HttpServletRequest;

public class UserBuilderFromRequest {

    /**
     * @param request to extract from it the user data
     * @param user    to extract the user Role and password
     * @return new user after coping the proper data from the request and the user object.
     */
    public User buildUserForUpdate(HttpServletRequest request, User user) {
        String id = request.getParameter(UserConstant.ID);
        String name = request.getParameter(UserConstant.NAME);
        String lastName = request.getParameter(UserConstant.LAST_NAME);
        String email = request.getParameter(UserConstant.EMAIL);
        String login = request.getParameter(UserConstant.LOGIN);
        String password = request.getParameter(UserConstant.PASSWORD);
        Role role = user.getRole();
        String blocked = request.getParameter(UserConstant.BLOCKED);

        return new User(Long.valueOf(id), name, lastName, email, login, password, role, Boolean.valueOf(blocked.trim()));
    }

    /**
     * @param request to extract from it the user data
     * @return the needed fields which has no default value in the sql table to use it
     * for saving user in the database
     */
    public User buildUserForInserting(HttpServletRequest request) {
        String name = request.getParameter(UserConstant.NAME);
        String lastName = request.getParameter(UserConstant.LAST_NAME);
        String email = request.getParameter(UserConstant.EMAIL);
        String login = request.getParameter(UserConstant.LOGIN);
        String password = request.getParameter(UserConstant.PASSWORD);
        return new User(name, lastName, email, login, password);
    }

}
