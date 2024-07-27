package com.example.escuela.services;

import com.example.escuela.models.Auth;
import com.example.escuela.models.Usuario;

public interface AuthServiceI{
    Auth login(Usuario usuario);
    Auth registro(Usuario usuario);
}
