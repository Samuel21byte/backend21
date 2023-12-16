/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.unamad.BackEndProducto.repository;

import com.unamad.BackEndProducto.entity.Producto;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author ACER
 */
public interface IProductoRepository extends Repository<Producto, Integer> {
    List<Producto> findAll();//Utilizamos el método findAll, lo que hace es devolver una lista de persona
    Producto findById(int Id_Producto); //El método findByID recibe un parámetro, va a buscar el id y va a devolver una persona
    Producto save(Producto pro);//El método save guarda, recibe un parámetro persona 
    void delete (Producto pro); //Método delete, recibe una persona y elimina
}
