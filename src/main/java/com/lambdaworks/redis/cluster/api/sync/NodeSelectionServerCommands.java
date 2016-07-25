package com.lambdaworks.redis.cluster.api.sync;

import java.util.Date;
import java.util.List;
import com.lambdaworks.redis.KillArgs;
import com.lambdaworks.redis.protocol.CommandType;

/**
 * Synchronous executed commands on a node selection for Server Control.
 * 
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mark Paluch
 * @since 4.0
 * @generated by com.lambdaworks.apigenerator.CreateSyncNodeSelectionClusterApi
 */
public interface NodeSelectionServerCommands<K, V> {

    /**
     * Asynchronously rewrite the append-only file.
     * 
     * @return String simple-string-reply always {@code OK}.
     */
    Executions<String> bgrewriteaof();

    /**
     * Asynchronously save the dataset to disk.
     * 
     * @return String simple-string-reply
     */
    Executions<String> bgsave();

    /**
     * Get the current connection name.
     * 
     * @return K bulk-string-reply The connection name, or a null bulk reply if no name is set.
     */
    Executions<K> clientGetname();

    /**
     * Set the current connection name.
     * 
     * @param name the client name
     * @return simple-string-reply {@code OK} if the connection name was successfully set.
     */
    Executions<String> clientSetname(K name);

    /**
     * Kill the connection of a client identified by ip:port.
     * 
     * @param addr ip:port
     * @return String simple-string-reply {@code OK} if the connection exists and has been closed
     */
    Executions<String> clientKill(String addr);

    /**
     * Kill connections of clients which are filtered by {@code killArgs}
     *
     * @param killArgs args for the kill operation
     * @return Long integer-reply number of killed connections
     */
    Executions<Long> clientKill(KillArgs killArgs);

    /**
     * Stop processing commands from clients for some time.
     * 
     * @param timeout the timeout value in milliseconds
     * @return String simple-string-reply The command returns OK or an error if the timeout is invalid.
     */
    Executions<String> clientPause(long timeout);

    /**
     * Get the list of client connections.
     * 
     * @return String bulk-string-reply a unique string, formatted as follows: One client connection per line (separated by LF),
     *         each line is composed of a succession of property=value fields separated by a space character.
     */
    Executions<String> clientList();

    /**
     * Returns an array reply of details about all Redis commands.
     * 
     * @return List&lt;Object&gt; array-reply
     */
    Executions<List<Object>> command();

    /**
     * Returns an array reply of details about the requested commands.
     * 
     * @param commands the commands to query for
     * @return List&lt;Object&gt; array-reply
     */
    Executions<List<Object>> commandInfo(String... commands);

    /**
     * Returns an array reply of details about the requested commands.
     * 
     * @param commands the commands to query for
     * @return List&lt;Object&gt; array-reply
     */
    Executions<List<Object>> commandInfo(CommandType... commands);

    /**
     * Get total number of Redis commands.
     * 
     * @return Long integer-reply of number of total commands in this Redis server.
     */
    Executions<Long> commandCount();

    /**
     * Get the value of a configuration parameter.
     * 
     * @param parameter name of the parameter
     * @return List&lt;String&gt; bulk-string-reply
     */
    Executions<List<String>> configGet(String parameter);

    /**
     * Reset the stats returned by INFO.
     * 
     * @return String simple-string-reply always {@code OK}.
     */
    Executions<String> configResetstat();

    /**
     * Rewrite the configuration file with the in memory configuration.
     * 
     * @return String simple-string-reply {@code OK} when the configuration was rewritten properly. Otherwise an error is
     *         returned.
     */
    Executions<String> configRewrite();

    /**
     * Set a configuration parameter to the given value.
     * 
     * @param parameter the parameter name
     * @param value the parameter value
     * @return String simple-string-reply: {@code OK} when the configuration was set properly. Otherwise an error is returned.
     */
    Executions<String> configSet(String parameter, String value);

    /**
     * Return the number of keys in the selected database.
     * 
     * @return Long integer-reply
     */
    Executions<Long> dbsize();

    /**
     * Crash and recover
     * @param delay optional delay in milliseconds
     * @return String simple-string-reply
     */
    Executions<String> debugCrashAndRecover(Long delay);

    /**
     * Get debugging information about the internal hash-table state.
     *
     * @param db the database number
     * @return String simple-string-reply
     */
    Executions<String> debugHtstats(int db);

    /**
     * Get debugging information about a key.
     * 
     * @param key the key
     * @return String simple-string-reply
     */
    Executions<String> debugObject(K key);

    /**
     * Save RDB, clear the database and reload RDB.
     *
     * @return String simple-string-reply The commands returns OK on success.
     */
    Executions<String> debugReload();

    /**
     * Restart the server gracefully.
     * @param delay optional delay in milliseconds
     * @return String simple-string-reply
     */
    Executions<String> debugRestart(Long delay);

    /**
     * Get debugging information about the internal SDS length.
     *
     * @param key the key
     * @return String simple-string-reply
     */
    Executions<String> debugSdslen(K key);

    /**
     * Remove all keys from all databases.
     * 
     * @return String simple-string-reply
     */
    Executions<String> flushall();

    /**
     * Remove all keys asynchronously from all databases.
     *
     * @return String simple-string-reply
     */
    Executions<String> flushallAsync();

    /**
     * Remove all keys from the current database.
     * 
     * @return String simple-string-reply
     */
    Executions<String> flushdb();

    /**
     * Remove all keys asynchronously from the current database.
     *
     * @return String simple-string-reply
     */
    Executions<String> flushdbAsync();

    /**
     * Get information and statistics about the server.
     * 
     * @return String bulk-string-reply as a collection of text lines.
     */
    Executions<String> info();

    /**
     * Get information and statistics about the server.
     * 
     * @param section the section type: string
     * @return String bulk-string-reply as a collection of text lines.
     */
    Executions<String> info(String section);

    /**
     * Get the UNIX time stamp of the last successful save to disk.
     * 
     * @return Date integer-reply an UNIX time stamp.
     */
    Executions<Date> lastsave();

    /**
     * Synchronously save the dataset to disk.
     * 
     * @return String simple-string-reply The commands returns OK on success.
     */
    Executions<String> save();

    /**
     * Make the server a slave of another instance, or promote it as master.
     * 
     * @param host the host type: string
     * @param port the port type: string
     * @return String simple-string-reply
     */
    Executions<String> slaveof(String host, int port);

    /**
     * Promote server as master.
     * 
     * @return String simple-string-reply
     */
    Executions<String> slaveofNoOne();

    /**
     * Read the slow log.
     * 
     * @return List&lt;Object&gt; deeply nested multi bulk replies
     */
    Executions<List<Object>> slowlogGet();

    /**
     * Read the slow log.
     * 
     * @param count the count
     * @return List&lt;Object&gt; deeply nested multi bulk replies
     */
    Executions<List<Object>> slowlogGet(int count);

    /**
     * Obtaining the current length of the slow log.
     * 
     * @return Long length of the slow log.
     */
    Executions<Long> slowlogLen();

    /**
     * Resetting the slow log.
     * 
     * @return String simple-string-reply The commands returns OK on success.
     */
    Executions<String> slowlogReset();

    /**
     * Return the current server time.
     * 
     * @return List&lt;V&gt; array-reply specifically:
     * 
     *         A multi bulk reply containing two elements:
     * 
     *         unix time in seconds. microseconds.
     */
    Executions<List<V>> time();
}
