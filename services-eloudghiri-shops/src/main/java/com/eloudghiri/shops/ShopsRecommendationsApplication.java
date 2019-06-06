package com.eloudghiri.shops;


import com.eloudghiri.shops.configurations.CORSFilter;
import com.eloudghiri.shops.dtos.mapper.ShopMapper;
import com.eloudghiri.shops.dtos.mapper.UserMapper;
import com.eloudghiri.shops.entities.Coordinate;
import com.eloudghiri.shops.entities.Shop;
import com.eloudghiri.shops.repositories.CoordinateRepository;
import com.eloudghiri.shops.repositories.ShopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackageClasses = {ShopMapper.class, UserMapper.class})
public class ShopsRecommendationsApplication {

	@Bean
	public FilterRegistrationBean crosFilterRegistration(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CORSFilter());
		registrationBean.setName("CORS Filter");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1);
		return registrationBean;
	}


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ShopsRecommendationsApplication.class, args);

		ShopRepository shopRepository = context.getBean(ShopRepository.class);
		CoordinateRepository coordinateRepository = context.getBean(CoordinateRepository.class);

		Coordinate coordinate1 = new Coordinate().setPositionX(-12.0).setPositionY(25.0);
		Shop shop1 = new Shop().setAdresse("Avenue FAL OUALD OUMIR, Agdal 10000, Rabat").setCoordinate(coordinate1).setName("MCDONALD AGDAL").setUri("https://p4.storage.canalblog.com/49/70/260332/19865646.jpg");
		shopRepository.save(shop1);

		Coordinate coordinate2 = new Coordinate().setPositionX(12.0).setPositionY(25.0);
		Shop shop2 = new Shop().setAdresse("24 Avenue Moulay Ismail, Rabat 10020").setCoordinate(coordinate2).setName("Café Ça100Bon").setUri("https://lh5.googleusercontent.com/p/AF1QipM6xPoT6fJWKqdFmrNRx8x2UwQUtIddHA8m4o-b=s611-k-no");
		shopRepository.save(shop2);

		Coordinate coordinate3 = new Coordinate().setPositionX(12.0).setPositionY(25.0);
		Shop shop3 = new Shop().setAdresse("Mahaj Ryad, Hay Riad, Rabat").setCoordinate(coordinate3).setName("VENIZIA ICE RIAD").setUri("https://image.jimcdn.com/app/cms/image/transf/none/path/sf0717ce5620da2df/image/i46a8ed71f4d43b82/version/1516565214/image.jpg");
		shopRepository.save(shop3);

		Coordinate coordinate4 = new Coordinate().setPositionX(26.0).setPositionY(90.0);
		Shop shop4 = new Shop().setAdresse("Hay riad").setCoordinate(coordinate4).setName("BurgerKing HayRiad").setUri("http://www.croatiaweek.com/wp-content/uploads/2015/06/bk1.jpg");
		shopRepository.save(shop4);

		Coordinate coordinate5 = new Coordinate().setPositionX(-2.0).setPositionY(55.0);
		Shop shop5 = new Shop().setAdresse("Agdal").setCoordinate(coordinate5).setName("StarBucks").setUri("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrycgidQ7-qpe0r9fRoGomUh7PiTEgrk3uJLjB3R_SMmdhsnYyAA");
		shopRepository.save(shop5);

		Coordinate coordinate6 = new Coordinate().setPositionX(12.0).setPositionY(38.0);
		Shop shop6 = new Shop().setAdresse("Hay Riad").setCoordinate(coordinate6).setName("latium").setUri("https://d1725by1tgdpky.cloudfront.net/330x220/1273681387/006.jpg");
		shopRepository.save(shop6);

		Coordinate coordinate7 = new Coordinate().setPositionX(-24.0).setPositionY(72.0);
		Shop shop7 = new Shop().setAdresse("Rabat, le Minaret").setCoordinate(coordinate7).setName("Chez Omar").setUri("https://media-cdn.tripadvisor.com/media/photo-s/06/dc/a3/18/bon-appetit.jpg");
		shopRepository.save(shop7);

		Coordinate coordinate8 = new Coordinate().setPositionX(-8.0).setPositionY(-42.0);
		Shop shop8 = new Shop().setAdresse("Agdal, fal ould Oumeir").setCoordinate(coordinate8).setName("Yoka sushi").setUri("http://ca-roule.ma/uploads/images/additional/gallery_large/8mb99tCOuOIqHnJTsBwt85SyS4FX3CoC.jpg");
		shopRepository.save(shop8);
	}

}
