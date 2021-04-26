package server.commandModule;

import another.connection.request.Request;
import another.connection.response.ResponseType;
import another.exceptions.NoArgumentException;
import another.exceptions.NoSuchCommandException;
import another.exceptions.UncorrectedFieldException;
import server.commandModule.commands.Command;
import server.collection.spaceMarineCreation.SpaceMarineFactory;

public interface ClientCommandManager extends CommandManager{
    Command convertToCommandFromRequest(Request request, SpaceMarineFactory spaceMarineFactory)
            throws NoSuchCommandException, NoArgumentException, UncorrectedFieldException;

    ResponseType getResponseTypeOfCommandExecution(Command command);
}
