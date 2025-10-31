package com.rafaelcaxixi.usuario_service.controllers;

import com.rafaelcaxixi.usuario_service.domain.dto.UsuarioRequestDto;
import com.rafaelcaxixi.usuario_service.domain.dto.UsuarioResponseDto;
import com.rafaelcaxixi.usuario_service.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> criarUsuario(@RequestBody @Valid UsuarioRequestDto usuarioRequestDto) {
        return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuarioRequestDto));
    }

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @GetMapping("/usuario-existe/{id}")
    public  ResponseEntity<Boolean> usuarioExiste(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.usuarioExiste(id));
    }
}
