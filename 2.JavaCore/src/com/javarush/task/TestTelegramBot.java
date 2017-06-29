package com.javarush.task;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.*;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
/**
 * Created by cherevko-vv on 29.06.2017.
 */
public class TestTelegramBot  extends TelegramLongPollingBot {
    @Override
    public String getBotToken() {
        return "435588447:AAHdigCUhmdFGLkiak1DCXORcw_xYybJuEg";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            if (message.getText().equals("/help"))
                sendMsg(message, "Привет, я робот");
            else if (message.getText().toLowerCase().equals("Корамин".toLowerCase())){
                sendMsg(message,"Биорегулятор сердца\n" +
                        "Нормализует и поддерживает функции сердца, ускоряет восстановление сердечной мышцы, улучшает переносимость физических нагрузок\n" +
                        "Форма выпуска: 40 таблеток в упаковке \n" + "http://fitopreparatyi-rostov.ru/tsitaminy/item/15-koramin");
            }
            else if (message.getText().toLowerCase().equals("Нормофлорин".toLowerCase())){
                sendMsg(message, "Средство для нормализации микрофлоры кишечника и профилактики дисбактериоза. \n В составе  Лактобактерии (L.casei) не менее 1 млрд. микробных клеток в 1 мл. и бифидобактерии (B. longum, B. bifidum) не менее 100 млн. микробных клеток в 1 мл" +
                "\n http://fitopreparatyi-rostov.ru/lechenie-i-profilaktika-disbakterioza/probiotiki/item/20-normoflorin-d");
            }
            else
                sendMsg(message, "Я не знаю что ответить на это");
        }
    }

    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "FitoAptekaBot";
    }

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new TestTelegramBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
