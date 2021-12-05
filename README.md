# What's the purpose?
This is a small project, which serves as a place to get a better grasp of hexagonal architecture in practice.  

## Materials, which helped me to understand hexagonal concept and other thoughts from DDD
> [Hexagonal architecture](https://herbertograca.com/2017/11/16/explicit-architecture-01-ddd-hexagonal-onion-clean-cqrs-how-i-put-it-all-together/) <br />
> [Anemic Domain Model](https://martinfowler.com/bliki/AnemicDomainModel.html)

### Following are the tools I'd like to use as well:
* **HATEOAS** to build Hypermedia-driven REST
* Plug the **Code style** (or similar) in

### How to run the project?
```sh
mvn clean compile
```
Open Api defined in `orders-api.yaml` will be generated, as well as classes for mapstruct to map domain model to presentation models.
```sh
./mvnw spring-boot:run
```

API exposed is available in `src/main/resources/orders-api.yaml` file.