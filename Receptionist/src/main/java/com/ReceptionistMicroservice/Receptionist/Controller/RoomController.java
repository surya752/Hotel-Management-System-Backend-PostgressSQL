package com.ReceptionistMicroservice.Receptionist.Controller;

import com.ReceptionistMicroservice.Receptionist.Entity.Room;
import com.ReceptionistMicroservice.Receptionist.Service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/Receptionist")
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        super();
        this.roomService = roomService;
    }
    @PostMapping("/room/save")
    public ResponseEntity<Room> saveRoom(@Valid @RequestBody Room room){
        return new ResponseEntity<Room>(roomService.saveRoom(room), HttpStatus.CREATED);
    }
    @GetMapping("/room/list")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }
    @GetMapping("room/{id}")
    public ResponseEntity<Room> getById(@PathVariable("id") int id){
        return new ResponseEntity<Room>(roomService.getById(id),HttpStatus.OK);
    }
    @PutMapping("room/edit/{id}")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room,@PathVariable("id") int id){
        return new ResponseEntity<Room>(roomService.updateRoom(room,id),HttpStatus.OK);
    }
    @DeleteMapping("room/delete/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable("id") int id){
        roomService.deleteRoom(id);
        return new ResponseEntity<String>("Room Deleted",HttpStatus.OK);
    }
}
