/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.unamad.BackEndProducto.service;

import com.unamad.BackEndProducto.entity.Producto;
import java.util.List;


/**
 *
 * @author ACER
 */
public interface IProductoService {
    List<Producto> listar();
    Producto listarId(int Id_Producto);
    Producto add(Producto pro);
    Producto edit(Producto pro);
    Producto delete(int Id_Producto);
}
