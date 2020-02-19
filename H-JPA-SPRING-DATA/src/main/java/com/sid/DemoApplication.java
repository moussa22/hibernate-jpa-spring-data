package com.sid;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sid.dao.CategorieRepository;
import com.sid.dao.ProduitRepository;
import com.sid.enties.Categorie;
import com.sid.enties.Produit;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(DemoApplication.class, args);
		ProduitRepository produitdao=ctx.getBean(ProduitRepository.class);
		CategorieRepository categorie=ctx.getBean(CategorieRepository.class);



		Categorie c1=new Categorie("Ordinateur");

		Categorie c2=new Categorie("Frigo");

		categorie.save(c1);
		categorie.save(c2);
		produitdao.save(new Produit("LX450",8000,7,c1));

		produitdao.save(new Produit("LX451",9000,8,c2));

		produitdao.save(new Produit("LX452",8000,9,c1));

		List<Produit> produits=produitdao.produitsParMC("%L%");

		for(Produit p:produits) {

			//System.out.println("Designtion"+p.getDesignation());
			//System.out.println("Prix"+p.getPrix());
			//System.out.println("Quantite"+p.getQuantite());

			System.out.println(p.toString());




		}
	}

}
