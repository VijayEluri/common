package org.echosoft.common.data;

/**
 * Один из способов поточной обработки данных, когда обработчик передается в виде callback поставщику данных.
 *
 * @author Anton Sharapov
 */
public interface Consumer<T> extends AutoCloseable {

    /**
     * Вызывается перед началом обработки массива данных.
     * Является подходящим местом для инициализации всех требуемых обработчиком ресурсов.
     */
    public void init() throws Exception;

    /**
     * Основной метод. Вызывается для каждой записи обрабатываемого массива данных.
     *
     * @param record  текущая обрабатываемая запись.
     */
    public void consume(T record) throws Exception;

    /**
     * Вызывается по завершении обработки последнего элемента массива данных.
     * Является подходящим местом для освобождения всех ресурсов затребованных обработчиком.
     */
    @Override
    public void close() throws Exception;
}
