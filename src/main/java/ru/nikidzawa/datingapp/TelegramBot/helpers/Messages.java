package ru.nikidzawa.datingapp.TelegramBot.helpers;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Messages {

    //REGISTRATION
    @Value("${ASK_NAME}")
    String ASK_NAME;

    @Value("${ASK_AGE}")
    String ASK_AGE;

    @Value("${ASK_CITY}")
    String ASK_CITY;

    @Value("${ASK_HOBBY}")
    String ASK_HOBBY;

    @Value("${ASK_ABOUT_ME}")
    String ASK_ABOUT_ME;

    @Value("${ASK_PHOTO}")
    String ASK_PHOTO;

    @Value("${RESULT}")
    String RESULT;

    //EDIT
    @Value("${EDIT_NAME}")
    String EDIT_NAME;

    @Value("${EDIT_AGE}")
    String EDIT_AGE;

    @Value("${EDIT_CITY}")
    String EDIT_CITY;

    @Value("${EDIT_PHOTO}")
    String EDIT_PHOTO;

    @Value("${NULL_DATA_EDIT}")
    String NULL_DATA_EDIT;

    @Value("${EDIT_RESULT}")
    String EDIT_RESULT;

    @Value("${UNEDITED_PHOTO}")
    String UNEDITED_PHOTO;

    @Value("${UNEDITED_HOBBY}")
    String UNEDITED_HOBBY;

    @Value("${UNEDITED_ABOUT_ME}")
    String UNEDITED_ABOUT_ME;

    @Value("${ASK_BEFORE_OFF}")
    String ASK_BEFORE_OFF;


    //MENU
    @Value("${MENU}")
    String MENU;
    @Value("${EDIT_PROFILE}")
    String EDIT_PROFILE;


    //LEFT GROUP OR DISABLE PROFILE
    @Value("${LEFT}")
    String LEFT;


    //EXCEPTIONS
    @Value("${NOT_GROUP_MEMBER_EXCEPTION}")
    String NOT_GROUP_MEMBER_EXCEPTION;

    @Value("${INVALID_FORMAT_EXCEPTION}")
    String INVALID_FORMAT_EXCEPTION;

    @Value("${IS_NOT_A_NUMBER_EXCEPTION}")
    String IS_NOT_A_NUMBER_EXCEPTION;

    @Value("${AGE_LIMIT_SYMBOLS_EXCEPTIONS}")
    String AGE_LIMIT_SYMBOLS_EXCEPTIONS;

    @Value("${NAME_LIMIT_SYMBOLS_EXCEPTIONS}")
    String NAME_LIMIT_SYMBOLS_EXCEPTIONS;

    @Value("${HOBBY_LIMIT_SYMBOLS_EXCEPTIONS}")
    String HOBBY_LIMIT_SYMBOLS_EXCEPTIONS;

    @Value("${ABOUT_ME_LIMIT_SYMBOLS_EXCEPTIONS}")
    String ABOUT_ME_LIMIT_SYMBOLS_EXCEPTIONS;

    @Value("${CITY_LIMIT_SYMBOLS_EXCEPTIONS}")
    String CITY_LIMIT_SYMBOLS_EXCEPTIONS;
}
