package edu.fpdual.persistence.connector;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MySQLConnectorTest {

    @Mock
    private Properties propMock;

    @Mock
    private MySQLConnector connectorMock;

    @Mock
    private IOException exceptionMock;

    @Test
    public void MySQLConnectorConstruction_ko() throws IOException {

    }

}
