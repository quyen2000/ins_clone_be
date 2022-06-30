package com.freq.auth.service.implementation;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.freq.auth.payload.post.response.PagedResponse;
import com.freq.auth.payload.post.response.notification.NotificationsPayload;
import com.freq.auth.payload.post.response.profile.PrivateResponse;
import com.freq.auth.payload.user.UserIdentityAvailability;
import com.freq.auth.payload.user.UserProfile;
import com.freq.auth.payload.user.UserSummary;
import com.freq.auth.security.UserPrincipal;
import com.freq.auth.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser("anonymous")
public class UserServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService service;

    private static final String BASE_URL = "/api/users/";

    @Test
    @DisplayName("test get user Profile")
    void testGetUserProfile() throws Exception {
        UserProfile userProfile = new UserProfile(2L, "abcd", null, null, null);

        when(service.getUserProfile(any())).thenReturn(userProfile);

        mockMvc.perform(get(BASE_URL + userProfile.getUsername()).contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("test Private")
    void testSetIsPrivate() throws Exception {
        PrivateResponse privateResponse = new PrivateResponse(true);

        when(service.setIsPrivate(any())).thenReturn(privateResponse);

        mockMvc.perform(put(BASE_URL + "/me/private/").contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("test Delete User Photo ")
    void testDeleteUserPhoto() throws Exception {
        UserPrincipal userPrincipal = new UserPrincipal(1L, "Quyen", "trongquyen", "trongquyen2000@gmail.com", "1234567", null, null);

        when(service.updateUserPicture(any(),any())).thenReturn(null);

        mockMvc.perform(delete(BASE_URL + "/profile/photo").contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("test User Name Availability")
    void testCheckUsernameAvailability() throws Exception {
        UserIdentityAvailability userIdentityAvailability = new UserIdentityAvailability(true);

        when(service.checkUsernameAvailability(any())).thenReturn(userIdentityAvailability);

        mockMvc.perform(get(BASE_URL + "/checkUsernameAvailability").param("username", "sbcd").contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("test User Email Availability")
    void testCheckEmailAvailability() throws Exception {
        UserIdentityAvailability userIdentityAvailability = new UserIdentityAvailability(true);

        when(service.checkEmailAvailability(any())).thenReturn(userIdentityAvailability);

        mockMvc.perform(get(BASE_URL + "/user/checkEmailAvailability").param("email", "sbcd").contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("test get Users By Username Or Name")
    void testGetUsersByUsernameOrName() throws Exception {
        UserSummary userSummary = new UserSummary(1L, "trongquyen", "quyen", null);
        List<UserSummary> list = new ArrayList<>();
        list.add(userSummary);
        when(service.getUsersByUsernameOrName(0,30,"trongquyen")).thenReturn( new PagedResponse<>(list,1,1,1,1,true));

        mockMvc.perform(get(BASE_URL + "/search/trongquyen").contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());
    }
}
