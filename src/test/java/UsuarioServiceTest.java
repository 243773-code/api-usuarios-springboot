import com.crcsystems.dto.RegisterRequest;
import com.crcsystems.dto.UsuarioResponse;
import com.crcsystems.entity.Usuario;
import com.crcsystems.repository.UsuarioRepository;
import com.crcsystems.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void deberiaRegistrarUsuarioConPasswordEncriptada() {
        RegisterRequest request = new RegisterRequest("César", "cesar@test.com", "password123");
        Usuario usuarioGuardado = new Usuario("César", "cesar@test.com", "$2a$10$encryptedHash", "ACTIVO");
        usuarioGuardado.setId(1L);

        when(usuarioRepository.existsByEmail(request.email())).thenReturn(false);
        when(passwordEncoder.encode(request.password())).thenReturn("$2a$10$encryptedHash");
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioGuardado);

        UsuarioResponse response = usuarioService.registrar(request);

        assertNotNull(response);
        assertEquals("César", response.nombre());
        assertEquals("cesar@test.com", response.email());

        verify(passwordEncoder, times(1)).encode("password123");
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }
}