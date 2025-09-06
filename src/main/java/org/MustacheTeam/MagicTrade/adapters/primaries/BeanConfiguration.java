package org.MustacheTeam.MagicTrade.adapters.primaries;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.JpaTradeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.SpringDataTradeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal.JpaTradeProposalRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal.SpringDataTradeProposalRepository;
import org.MustacheTeam.MagicTrade.adapters.security.AuthenticationService;
import org.MustacheTeam.MagicTrade.adapters.security.JwtAuthenticationFilter;
import org.MustacheTeam.MagicTrade.corelogics.gateways.api.ScryfallGateway;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.JpaUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.*;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.JpaCardRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.EnchantmentType.JpaEnchantmentTypeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.EnchantmentType.SpringDataEnchantmentTypeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.ability.JpaAbilityRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.ability.SpringDataAbilityRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.artifacttype.JpaArtifactTypeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.artifacttype.SpringDataArtifactTypeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.cardType.JpaCardTypeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.cardType.SpringDataCardTypeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.cardname.JpaCardNameRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.cardname.SpringdataCardNameRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.creaturetype.JpaCreatureTypeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.creaturetype.SpringDataCreatureTypeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.power.JpaPowerRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.power.SpringDataPowerRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.landtype.JpaLandTypeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.landtype.SpringDataLandTypeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.toughness.JpaToughnessRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.toughness.SpringDataToughnessRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.JpaCollectionRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.SpringDataCollectionRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.doublecard.JpaDoubleCardRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.SpringDataCardRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.doublecard.SpringDataDoubleCardRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.set.JpaSetRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.set.SpringDataSetRepository;
import org.MustacheTeam.MagicTrade.adapters.security.PasswordEncoderService;
import org.MustacheTeam.MagicTrade.adapters.security.JwtService;
import org.MustacheTeam.MagicTrade.corelogics.usecases.card.GetAllCards;
import org.MustacheTeam.MagicTrade.corelogics.usecases.card.RefreshCards;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.ability.GetAllAbilities;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.ability.RefreshAbilities;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.artifacttype.GetAllArtifactType;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.artifacttype.RefreshArtifactType;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.cardType.GetAllCardTypes;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.cardType.RefreshCardTypes;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.cardname.GetAllCardNames;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.cardname.RefreshCardNames;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.creaturetype.GetAllCreatureTypes;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.creaturetype.RefreshCreatureTypes;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.enchantmentType.GetAllEnchantmentTypes;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.enchantmentType.RefreshEnchantmentType;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.landtype.GetAllLandTypes;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.landtype.RefreshLandTypes;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.power.GetAllPowers;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.power.RefreshPowers;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.toughness.GetAllToughnesses;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.toughness.RefreshToughnesses;
import org.MustacheTeam.MagicTrade.corelogics.usecases.collection.CreateCollection;
import org.MustacheTeam.MagicTrade.corelogics.usecases.doublecard.GetAllDoubleCards;
import org.MustacheTeam.MagicTrade.corelogics.usecases.set.RefreshSets;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.CreateTrade;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal.CreateTradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal.GetAllProposalsByOneTrades;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.GetAllTradesByUserId;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal.UpdateOneProposal;
import org.MustacheTeam.MagicTrade.corelogics.usecases.user.CreateUser;
import org.MustacheTeam.MagicTrade.adapters.security.CustomUserDetailsService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.client.RestTemplate;

@Configuration
@EntityScan(basePackages = {"org.MustacheTeam.MagicTrade.adapters.secondaries.gateways"})
@EnableJpaRepositories(basePackages = {"org.MustacheTeam.MagicTrade.adapters.secondaries.gateways"})
public class BeanConfiguration {

    @Bean
    public JpaUserRepository jpaUserRepository(SpringDataUserRepository springDataUserRepository, PasswordEncoderService passwordEncoder){
        return new JpaUserRepository(springDataUserRepository, passwordEncoder);
    }

    @Bean
    public CreateUser createUser( UserRepository userRepository) {
        return new CreateUser(userRepository);
    }


    @Bean
    public JpaCardRepository jpaCardRepository(SpringDataCardRepository springDataCardRepository){
        return new JpaCardRepository(springDataCardRepository);
    }

    @Bean
    GetAllCards getAllCards(CardRepository cardRepository){
        return new GetAllCards(cardRepository);
    }

    @Bean
    public RefreshCards refreshCards(RealScryfallGateway realScryfallGateway,JpaCardRepository cardRepository){
        return new RefreshCards(realScryfallGateway, cardRepository);
    }

    @Bean
    public JpaCollectionRepository jpaCollectionRepository(SpringDataCollectionRepository springDataCollectionRepository,
            SpringDataCardRepository springDataCardRepository, SpringDataUserRepository springDataUserRepository){
        return new JpaCollectionRepository(springDataCollectionRepository,springDataCardRepository,springDataUserRepository);
    }

    @Bean
    public CreateCollection createCollection(JpaCollectionRepository jpaCollectionRepository){
        return new CreateCollection(jpaCollectionRepository);
    }

    @Bean
    public JpaDoubleCardRepository jpaDoubleCardRepository(SpringDataDoubleCardRepository springDataDoubleCardRepository){
        return new JpaDoubleCardRepository(springDataDoubleCardRepository);
    }

    @Bean
    public GetAllDoubleCards getAllDoubleCards(JpaDoubleCardRepository jpaDoubleCardRepository){
        return new GetAllDoubleCards(jpaDoubleCardRepository);
    }


    @Bean
    public JpaSetRepository jpaSetRepository(SpringDataSetRepository springDataSetRepository){
        return new JpaSetRepository(springDataSetRepository);
    }

    @Bean
    public RefreshSets refreshSets(RealScryfallGateway realScryfallGateway, JpaSetRepository jpaSetRepository){
        return new RefreshSets(realScryfallGateway, jpaSetRepository);
    }

    @Bean
    public JpaCardTypeRepository jpaCardTypeRepository(SpringDataCardTypeRepository springDataCardTypeRepository){
        return new JpaCardTypeRepository(springDataCardTypeRepository);
    }

    @Bean
    public GetAllCardTypes getAllCardTypes(CardTypeRepository cardTypeRepository){
        return new GetAllCardTypes(cardTypeRepository);
    }

    @Bean
    public RefreshCardTypes refreshCardTypes(ScryfallGateway scryfallGateway, CardTypeRepository cardTypeRepository){
        return new RefreshCardTypes(scryfallGateway, cardTypeRepository);
    }

    @Bean
    public JpaCreatureTypeRepository jpaCreatureTypeRepository(SpringDataCreatureTypeRepository springDataCreatureTypeRepository){
        return new JpaCreatureTypeRepository(springDataCreatureTypeRepository);
    }

    @Bean
    public GetAllCreatureTypes getAllCreatureTypes(CreatureTypeRepository creatureTypeRepository){
        return new GetAllCreatureTypes(creatureTypeRepository);
    }

    @Bean
    public RefreshCreatureTypes refreshCreatureTypes(ScryfallGateway scryfallGateway, CreatureTypeRepository creatureTypeRepository){
        return new RefreshCreatureTypes(scryfallGateway, creatureTypeRepository);
    }

    @Bean
    public JpaLandTypeRepository jpaLandTypeRepository(SpringDataLandTypeRepository springDataLandTypeRepository){
        return  new JpaLandTypeRepository(springDataLandTypeRepository);
    }

    @Bean
    public GetAllLandTypes getAllLandTypes(LandTypeRepository landTypeRepository){
        return new GetAllLandTypes(landTypeRepository);
    }

    @Bean
    public RefreshLandTypes refreshLandTypes(ScryfallGateway scryfallGateway, LandTypeRepository landTypeRepository){
        return  new RefreshLandTypes(scryfallGateway, landTypeRepository);
    }

    @Bean
    public JpaPowerRepository jpaPowerRepository(SpringDataPowerRepository springDataPowerRepository){
        return new JpaPowerRepository(springDataPowerRepository);
    }

    @Bean
    public GetAllPowers getAllPowers(PowerRepository powerRepository){
        return new GetAllPowers(powerRepository);
    }

    @Bean
    public RefreshPowers refreshPowers(ScryfallGateway scryfallGateway, PowerRepository powerRepository){
        return new RefreshPowers(scryfallGateway, powerRepository);
    }

    @Bean
    public JpaToughnessRepository jpaToughnessRepository(SpringDataToughnessRepository springDataToughnessRepository){
        return new JpaToughnessRepository(springDataToughnessRepository);
    }

    @Bean
    public GetAllToughnesses getAllToughnesses(ToughnessRepository toughnessRepository){
        return new GetAllToughnesses(toughnessRepository);
    }

    @Bean
    public RefreshToughnesses refreshToughnesses(ScryfallGateway scryfallGateway, ToughnessRepository toughnessRepository){
        return new RefreshToughnesses(scryfallGateway, toughnessRepository);
    }

    @Bean
    public JpaCardNameRepository jpaCardNameRepository(SpringdataCardNameRepository springdataCardNameRepository){
        return new JpaCardNameRepository(springdataCardNameRepository);
    }

    @Bean
    GetAllCardNames getAllCardNames(CardNameRepository cardNameRepository){
        return  new GetAllCardNames(cardNameRepository);
    }

    @Bean
    RefreshCardNames refreshCardNames(ScryfallGateway scryfallGateway, CardNameRepository cardNameRepository){
        return new RefreshCardNames(scryfallGateway, cardNameRepository);
    }

    @Bean
    public JpaAbilityRepository jpaAbilityRepository(SpringDataAbilityRepository springDataAbilityRepository){
        return new JpaAbilityRepository(springDataAbilityRepository);
    }

    @Bean
    public GetAllAbilities getAllAbilities(AbilityRepository abilityRepository){
        return new GetAllAbilities(abilityRepository);
    }

    @Bean
    public RefreshAbilities refreshAbilities(ScryfallGateway scryfallGateway, AbilityRepository abilityRepository){
        return  new RefreshAbilities(scryfallGateway,abilityRepository);
    }

    @Bean
    public JpaArtifactTypeRepository jpaArtifactTypeRepository(SpringDataArtifactTypeRepository springDataArtifactTypeRepository){
        return new JpaArtifactTypeRepository(springDataArtifactTypeRepository);
    }

    @Bean
    public GetAllArtifactType getAllArtifactType(ArtifactTypeRepository artifactTypeRepository){
       return new GetAllArtifactType(artifactTypeRepository);
    }

    @Bean
    public RefreshArtifactType refreshArtifactType(ArtifactTypeRepository artifactTypeRepository, ScryfallGateway scryfallGateway){
        return new RefreshArtifactType(artifactTypeRepository, scryfallGateway);
    }

    @Bean
    public JpaEnchantmentTypeRepository jpaEnchantmentTypeRepository(SpringDataEnchantmentTypeRepository springDataEnchantmentTypeRepository){
        return new JpaEnchantmentTypeRepository(springDataEnchantmentTypeRepository);
    }

    @Bean
    GetAllEnchantmentTypes getAllEnchantmentTypes(EnchantmentTypeRepository enchantmentRepository){
        return new GetAllEnchantmentTypes(enchantmentRepository);
    }

    @Bean
    RefreshEnchantmentType refreshEnchantmentType(ScryfallGateway scryfallGateway, EnchantmentTypeRepository enchantmentRepository){
        return new RefreshEnchantmentType(scryfallGateway,enchantmentRepository);
    }

    @Bean
    JpaTradeRepository jpaTradeRepository(SpringDataTradeRepository repository, SpringDataUserRepository userRepository, SpringDataCollectionRepository collectionRepository){
        return new JpaTradeRepository(repository, userRepository, collectionRepository);
    }

    @Bean
    CreateTrade createTrade(TradeRepository tradeRepository){
        return new CreateTrade(tradeRepository);
    }

    @Bean
    GetAllTradesByUserId getAllTradesByUserId(TradeRepository tradeRepository){
        return new GetAllTradesByUserId(tradeRepository);
    }

    @Bean
    JpaTradeProposalRepository jpaTradeProposalRepository(SpringDataTradeProposalRepository repository,
                                                          SpringDataTradeRepository tradeRepository,
                                                          SpringDataUserRepository userRepository,
                                                          SpringDataCollectionRepository collectionRepository){
        return new JpaTradeProposalRepository(repository,tradeRepository,userRepository,collectionRepository);

    }
    @Bean
    CreateTradeProposal createTradeProposal(TradeProposalRepository repository){
        return new CreateTradeProposal(repository);
    }

    @Bean
    GetAllProposalsByOneTrades getAllProposalsByOneTrades(TradeProposalRepository repository){
        return new GetAllProposalsByOneTrades(repository);
    }

    @Bean
    UpdateOneProposal updateOneProposal(TradeProposalRepository repository){
        return new UpdateOneProposal(repository);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public RealScryfallGateway realScryfallGateway(){
        return new RealScryfallGateway(restTemplate());
    }

    @Bean
    public PasswordEncoderService passwordEncoderService(){
        return new PasswordEncoderService();
    }

    @Bean
    public AuthenticationService authenticationService(JwtService jwtService, AuthenticationManager authenticationManager){
        return new AuthenticationService(jwtService,authenticationManager);
     }

    @Bean
    JwtService jwtService(){
        return  new JwtService();
    }

    @Bean
    public CustomUserDetailsService customUserDetailsService(UserRepository userRepository){
        return new CustomUserDetailsService(userRepository);
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService){
        return new JwtAuthenticationFilter(jwtService,userDetailsService);
    }
}
