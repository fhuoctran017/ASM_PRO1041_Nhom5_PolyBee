/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asm.polybee.service;

import com.asm.polybee.model.ChatLieu;
import java.util.List;

/**
 *
 * @author phuoc
 */
public interface ChatLieuService {

    List<ChatLieu> getAll();

    boolean themChatLieu(ChatLieu chatLieu);
}
