package com.crcsystems.service;

import com.crcsystems.dto.RegisterRequest;
import com.crcsystems.dto.UsuarioResponse;
import com.crcsystems.entity.Usuario;
import com.crcsystems.exception.RecursoNoEncontradoException;
import com.crcsystems.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponse registrar(RegisterRequest request) {
        if (usuarioRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("El email ya se encuentra registrado");
        }

        // Hashing seguro de la contraseña con BCrypt
        String passwordEncriptada = passwordEncoder.encode(request.password());

        Usuario usuario = new Usuario(
                request.nombre(),
                request.email(),
                passwordEncriptada,
                "ACTIVO"
        );

        Usuario guardado = usuarioRepository.save(usuario);
        return UsuarioResponse.fromEntity(guardado);
    }

    public List<UsuarioResponse> obtenerTodos() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioResponse::fromEntity)
                .toList();
    }

    public UsuarioResponse obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado con ID: " + id));
        return UsuarioResponse.fromEntity(usuario);
    }

    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Usuario no encontrado con ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}