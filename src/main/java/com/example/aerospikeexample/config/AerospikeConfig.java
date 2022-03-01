//package com.example.aerospikeexample.config;
//
//
//import com.aerospike.client.AerospikeClient;
//import com.aerospike.client.IAerospikeClient;
//import com.aerospike.client.policy.ClientPolicy;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.data.aerospike.convert.AerospikeTypeAliasAccessor;
//import org.springframework.data.aerospike.convert.MappingAerospikeConverter;
//import org.springframework.data.aerospike.core.AerospikeTemplate;
//import org.springframework.data.aerospike.mapping.AerospikeMappingContext;
//import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableAerospikeRepositories(basePackages = "com.example.aerospikeexample")
//
//public class AerospikeConfig {
//
//        @Bean
//         public AerospikeTemplate aerospikeTemplate(){
//
//           return new AerospikeTemplate(aerospikeClient(),"test",)
//        }//provide aerospike tempolets
//
//    @Bean
//    public IAerospikeClient aerospikeClient() {
//        ClientPolicy clientPolicy=new ClientPolicy();
//        clientPolicy.failIfNotConnected=true;//mar king the policy for the aerospike client if the aerospike client is not able to connect
//        return new AerospikeClient(clientPolicy,"172.28.128.3",3000);
//    }
////
//}
//
//
//
