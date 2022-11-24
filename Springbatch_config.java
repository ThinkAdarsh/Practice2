package com.BATCH.Spring_batch.CONFIG;

import com.BATCH.Spring_batch.ENTITY.Customer;
import com.BATCH.Spring_batch.REPOSITORY.Customer_repository;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class Springbatch_config {

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    private Customer_repository customer_repository;

    //to read the information from the source
    @Bean
    public FlatFileItemReader<Customer> reader()
    {
        FlatFileItemReader<Customer> fileItemReader=new FlatFileItemReader<>();
        fileItemReader.setResource(new FileSystemResource("src/main/resources/Customer.csv"));
        fileItemReader.setName("CSVREADER");
        fileItemReader.setLinesToSkip(1);
        fileItemReader.setLineMapper(lineMapper());

        return fileItemReader;
    }

    private LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> lineMapper=new DefaultLineMapper<>();

        //it will extract the value from csv file
        DelimitedLineTokenizer delimitedLineTokenizer=new DelimitedLineTokenizer();

        //we do the comma separated
        delimitedLineTokenizer.setDelimiter(",");
        delimitedLineTokenizer.setStrict(false);
        //we set the header here
        delimitedLineTokenizer.setNames("id", "name", "location");

        //map the value to the target class
        BeanWrapperFieldSetMapper<Customer> fieldSetMapper=new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Customer.class);

        lineMapper.setLineTokenizer(delimitedLineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;

    }

    @Bean
    public Customer_processor processor()
    {
        return new Customer_processor();
    }

    @Bean
    public RepositoryItemWriter<Customer> writer()
    {
        RepositoryItemWriter<Customer> writer=new RepositoryItemWriter<>();
        writer.setRepository(customer_repository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1()
    {
        return stepBuilderFactory.get("csv-step").<Customer, Customer>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Job runjob()
    {
        return jobBuilderFactory.get("importCustomerinfo")
                .flow(step1()).end().build();
    }

    @Bean
    public TaskExecutor taskExecutor()
    {
        SimpleAsyncTaskExecutor asyncTaskExecutor=new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);

        return asyncTaskExecutor;
    }
}
