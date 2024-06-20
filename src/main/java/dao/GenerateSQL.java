package dao;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GenerateSQL {
    public static void main(String[] args) {
        // 開始日と終了日を設定
        LocalDate startDate = LocalDate.of(2024, 6, 1);
        LocalDate endDate = LocalDate.of(2024, 6, 30);
        int[] roomNumbers = {101, 201, 301, 401, 501, 601, 701, 801, 901, 1001};

        // 日付フォーマットの設定
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter reservIdFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("INSERT INTO ecoluxuryresort.reservation(reserv_id, acc_date, room_number, regist_id, state) VALUES\n");

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            for (int roomNumber : roomNumbers) {
                String reservId = date.format(reservIdFormatter) + roomNumber;
                String accDate = date.format(dateFormatter);
                sqlBuilder.append(String.format("('%s', '%s', %d, null, 'f'),\n", reservId, accDate, roomNumber));
            }
        }

        // 最後のカンマを削除してセミコロンに置き換え
        int lastCommaIndex = sqlBuilder.lastIndexOf(",");
        if (lastCommaIndex != -1) {
            sqlBuilder.replace(lastCommaIndex, lastCommaIndex + 1, ";");
        }

        // ファイルに書き込む
        try (FileWriter fileWriter = new FileWriter("insert_reservations.sql")) {
            fileWriter.write(sqlBuilder.toString());
            System.out.println("SQLスクリプトが生成されました。");
        } catch (IOException e) {
            System.err.println("ファイルの書き込み中にエラーが発生しました: " + e.getMessage());
        }
    }
}

