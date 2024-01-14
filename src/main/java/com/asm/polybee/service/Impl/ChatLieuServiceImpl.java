/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asm.polybee.service.Impl;

import com.asm.polybee.model.ChatLieu;
import com.asm.polybee.repository.ChatLieuRepository;
import com.asm.polybee.service.ChatLieuService;
import java.util.List;

/**
 *
 * @author phuoc
 */
public class ChatLieuServiceImpl implements ChatLieuService{

    private ChatLieuRepository repository = new ChatLieuRepository();
    
    @Override
    public List<ChatLieu> getAll() {
       return repository.getAll();
    }

    @Override
    public boolean themChatLieu(ChatLieu chatLieu) {
        if (chatLieu != null) {
            repository.themChatLieu(chatLieu);
            return true;
        } else {
            return false;
        }
    }
    
}
