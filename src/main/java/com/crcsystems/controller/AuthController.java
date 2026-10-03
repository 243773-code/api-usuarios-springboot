package com.crcsystems.controller;

import com.crcsystems.dto.ApiResponse;
import com.crcsystems.dto.RegisterRequest;
import com.crcsystems.dto.UsuarioResponse;
import com.crcsystems.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UsuarioResponse>> registrar(@Valid @RequestBody RegisterRequest request) {
        UsuarioResponse response = usuarioService.registrar(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("Usuario registrado exitosamente", response));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<ApiResponse<List<UsuarioResponse>>> listarTodos() {
        List<UsuarioResponse> usuarios = usuarioService.obtenerTodos();
        return ResponseEntity.ok(ApiResponse.success("Usuarios obtenidos correctamente", usuarios));
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<ApiResponse<UsuarioResponse>> obtenerPorId(@PathVariable Long id) {
        UsuarioResponse usuario = usuarioService.obtenerPorId(id);
        return ResponseEntity.ok(ApiResponse.success("Usuario encontrado", usuario));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.ok(ApiResponse.success("Usuario eliminado exitosamente", null));
    }
}