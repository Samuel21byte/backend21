/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unamad.BackEndProducto.controller;

import com.unamad.BackEndProducto.entity.Producto;
import com.unamad.BackEndProducto.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(("/productos"))
public class ProductoController {
    @Autowired
    IProductoService service;
    
    @GetMapping("/listar")
    public List<Producto> listar(){
        return this.service.listar();
    }
    
    /*Antiguo añadir
    @PostMapping
    public Producto agregar(@RequestBody Producto pro){
        return this.service.add(pro);
    }*/
    
    //Nuevo añadir
    @PostMapping("/agregar")
    public ResponseEntity<Producto> add(@RequestBody Producto nuevoProducto) {
        Producto productoAgregado = service.add(nuevoProducto);
        return ResponseEntity.ok(productoAgregado);
    }
    
    
    /*Antiguo Listar
    @GetMapping(path = {"/{id}"})
    public Producto listarId(@PathVariable("id") int Id_Producto){
        return service.listarId(Id_Producto);
    }*/
    
    //Nuevo Listar ID
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Producto> listarid(@PathVariable int id) {
        Producto pro = service.listarId(id);
        return pro != null ? ResponseEntity.ok(pro) : ResponseEntity.notFound().build();
    }
    
    /*Antiguo Editar
    @PutMapping(path = {"/{id}"})
    public Producto editar(@RequestBody Producto pro, @PathVariable("id") int Id_producto){
        pro.setId_producto(Id_producto);
        return service.edit(pro);
    }*/
    
    //Nuevo Editar
    public ResponseEntity<Producto> editar(@PathVariable int id, @RequestBody Producto productoActualizado) {
        Producto productoEditado = service.edit(productoActualizado);
        return productoEditado != null ? ResponseEntity.ok(productoEditado) : ResponseEntity.notFound().build();
    }
    
    /*Antiguo eliminar
    @DeleteMapping(path = "/{id}")
    public Producto delete(@PathVariable("id") int Id_Producto){
        return service.delete(Id_Producto);
    }*/
    
    //Nuevo Eliminar 
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        Producto productoEliminado = service.delete(id);
        return productoEliminado != null
                ? ResponseEntity.ok("Producto eliminado exitosamente")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el producto");
    }
}
