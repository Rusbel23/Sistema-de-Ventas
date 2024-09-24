package com.Tarea.demo.Controller;

import org.springframework.ui.Model; // Importación correcta
import com.Tarea.demo.Model.Product;
import com.Tarea.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Metodo para mostrar el formulario
    @GetMapping("/registrar-producto")
    public String rutaFormulario(Model model) {
        model.addAttribute("product", new Product());
        return "Formulario";
    }

    // Metodo para agregar producto
    @PostMapping("/registrar-producto")
    public String registrarProducto(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/productos";
    }

    // Metodo para listar productos
    @GetMapping("/productos")
    public ModelAndView listarProductos() {
        List<Product> productos = productService.getAllProducts();
        ModelAndView mav = new ModelAndView("ListarProductos");
        mav.addObject("ListarProductos", productos);
        return mav;
    }

    // Metodo para mostrar el formulario de actualización con datos del producto
    @GetMapping("/producto/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "Formulario";
    }

    // Método para actualizar el producto
    @PostMapping("/producto/actualizar/{id}")
    public String actualizarProducto(@PathVariable("id") Long id, @ModelAttribute Product product) {
        productService.updateProduct(id, product);
        return "redirect:/productos";
    }

    // Método para eliminar el producto
    @GetMapping("/producto/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/productos";
    }

}




