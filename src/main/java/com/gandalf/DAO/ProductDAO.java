package com.gandalf.DAO;

import com.gandalf.DTO.ProductDTO;
import com.gandalf.models.Produto;
import java.util.List;
import org.hibernate.criterion.Restrictions;

public class ProductDAO extends DAO {

    public List<Produto> get() {
        return session.createCriteria(Produto.class).list();
    }

    public Produto get(int id) {
        return (Produto) session.get(Produto.class, id);
    }

    public List<Produto> getForCategoria(int id) {
        return session
                .createCriteria(Produto.class)
                .add(Restrictions.eq("categoria.id", id))
                .list();
    }

    public List<Produto> like(String nomeProduto) {
        return session
                .createCriteria(Produto.class)
                .add(Restrictions
                        .like("nomeProduto", "%" + nomeProduto + "%"))
                .list();
    }

    public ProductDTO getProductDTO(Produto product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.id = product.getIdProduto();
        productDTO.name = product.getNomeProduto();
        productDTO.price = product.getPrecProduto();
        productDTO.discount = product.getDescontoPromocao();
        productDTO.stock = product.getQtdMinEstoque();
        productDTO.description = product.getDescProduto();
        productDTO.active = product.getAtivoProduto();
        productDTO.image = product.getImagem();
        return productDTO;
    }
}
