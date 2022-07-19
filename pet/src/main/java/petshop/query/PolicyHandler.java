package petshop.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import petshop.aggregate.*;
import petshop.command.*;
import petshop.event.*;

@Service
@ProcessingGroup("pet_Policy")
public class PolicyHandler {}
