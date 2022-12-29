package clc.inbound

import clc.outbound.UserRepository
import clc.shared.User
import clc.shared.dto.CreateUserRequestDto
import clc.shared.dto.UserDto
import clc.shared.mapper.DomainToDtoMapper
import clc.shared.mapper.DtoToDomainMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userRepository: UserRepository) {

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserDto>> {
        val users = userRepository.findAll();
        return ResponseEntity.ok(DomainToDtoMapper.fromUserList(users.toList()));
    }

    @PostMapping
    fun postUser(@RequestBody user: CreateUserRequestDto): ResponseEntity<UserDto> {
        val createdUser = userRepository.save(DtoToDomainMapper.from(user));
        return ResponseEntity.ok(DomainToDtoMapper.fromUser(createdUser));
    }

}