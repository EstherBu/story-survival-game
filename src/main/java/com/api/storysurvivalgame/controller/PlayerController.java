package com.api.storysurvivalgame.controller;

import com.api.storysurvivalgame.model.Player;

import com.api.storysurvivalgame.repository.PlayerRepository;
import com.api.storysurvivalgame.response.ErrorResponse;
import com.api.storysurvivalgame.response.PlayerResponse;
import com.api.storysurvivalgame.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @CrossOrigin
    @RestController
    @RequestMapping("/player")
    public class PlayerController {

        @Autowired
        private PlayerRepository playerRepository;

        @GetMapping("/{id}")
        public ResponseEntity<?> getPlayerById(@PathVariable int id) {
            Player player = this.playerRepository.findById(id).orElse(null);

            if (player == null) {
                ErrorResponse error = new ErrorResponse();
                error.set("Player not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            } else return ResponseEntity.ok(player);
        }

        @PostMapping
        public ResponseEntity<Response<?>> createPlayer(@RequestBody Player player) {
            PlayerResponse newPlayer = new PlayerResponse();

            if (player.getName() == null) {
                ErrorResponse error = new ErrorResponse();
                error.set("please insert a name");
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            }
            try {
                player.setHp(100);
                newPlayer.set(this.playerRepository.save(player));
            } catch (Exception e) {
                ErrorResponse error = new ErrorResponse();
                error.set("Bad request");
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
        }

        // not used in the front-end for now, but useful to update the hp of the player
        @PutMapping("/{id}")
        public ResponseEntity<Response<?>> updatePlayer(@PathVariable int id, @RequestBody Player player) {
            Player playerToUpdate = this.playerRepository.findById(id).orElse(null);

            if (playerToUpdate == null) {
                ErrorResponse error = new ErrorResponse();
                error.set("Player not found");
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
            }

            try {
                if (player.getHp() != 0) {
                    playerToUpdate.setHp(player.getHp());
                }

                this.playerRepository.save(playerToUpdate);

                PlayerResponse playerResponse = new PlayerResponse();
                playerResponse.set(playerToUpdate);
                return new ResponseEntity<>(playerResponse, HttpStatus.OK);
            } catch (Exception e) {
                ErrorResponse error = new ErrorResponse();
                error.set("Bad request");
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            }
        }
    }
