package com.crcsystems.dto;

import com.crcsystems.entity.Usuario;

public record UsuarioResponse(
        Long id,
        String nombre,
        String email,
        String estado
) {
    public static UsuarioResponse fromEntity(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getEstado()
        );
    }
}