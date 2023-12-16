/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unamad.BackEndProducto.service;

import com.unamad.BackEndProducto.entity.Producto;
import com.unamad.BackEndProducto.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired //El contexto de la app web, vas a crear un objeto de tipo Persona repositorio
    private IProductoRepository repositorio;
    //LEER CDI (Inyección de dependencias)
    
    @Override
    public List<Producto> listar() {
        return this.repositorio.findAll();
    }

    @Override
    public Producto listarId(int Id_Producto) {
        return repositorio.findById(Id_Producto);
    }

    @Override
    public Producto add(Producto pro) {
        return repositorio.save(pro);
    }

    @Override
    public Producto edit(Producto pro) {
        return repositorio.save(pro);
    }

    @Override
    public Producto delete(int Id_Producto) {
        Producto pro=repositorio.findById(Id_Producto);
        if(pro!=null){
            repositorio.delete(pro);
        }
        return pro;
    }

    
}
